package service;

import domain.RideDetails;
import domain.RideStatus;
import domain.User;
import exception.*;
import utils.Utils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Service class for Ride sharing application.
 *
 */
public class RideSharingServiceImpl implements RideSharingService{
    public static final String MOST_VACANT = "Most_Vacant";

    private List<User> userList;
    // List containing all active ride details (i.e whose status is offered or selected).
    private List<RideDetails> allActiveRideDetailsList;
    // Map storing {vehicleNo -> RideDetails which are in offered or selected state}
    private Map<String, RideDetails> activeRideDetailsMap;
    // Map containing info {userName -> count of ride offered}
    private Map<String, Integer> userNameToRideOfferedCountMap;
    // Map containing info {userName -> count of ride taken}
    private Map<String, Integer> userNameToRideTakenMap;

    public RideSharingServiceImpl() {
        this.userList = new ArrayList<>();
        this.allActiveRideDetailsList = new ArrayList<>();
        this.activeRideDetailsMap = new HashMap<>();
        this.userNameToRideOfferedCountMap = new HashMap<>();
        this.userNameToRideTakenMap = new HashMap<>();
    }

    /**
     * Function to add user in rideService.
     *
     * @param user
     */
    public void addUser(User user) {
        if (!Utils.isUserParamsValid(user)) {
            throw new InvalidAddUserRequestException("Invalid request to add new user");
        }

        userList.add(user);
    }

    /**
     * Function to handle offer ride.
     *
     * @param rideDetails
     */
    public void offerRide(RideDetails rideDetails) {
        if (!Utils.isOfferRideDetailsParamsValid(rideDetails)) {
            throw new InvalidRideDetailsRequestParamsException("Invalid request to offer ride");
        }

        if (activeRideDetailsMap.containsKey(rideDetails.getVehicleNo())) {
            throw new RideAlreadyOfferedException("This ride has already been offered");
        }

        // Changing the status of current ride.
        rideDetails.setRideStatus(RideStatus.OFFERED);
        // Putting the entry in active ride details map.
        activeRideDetailsMap.put(rideDetails.getVehicleNo(), rideDetails);

        allActiveRideDetailsList.add(rideDetails);
    }

    /**
     * Function to handle select ride.
     *
     * @param source
     * @param destination
     * @param seats
     * @param selectionStrategy
     * @return
     */
    public String selectRide(String riderName, String source, String destination, Integer seats, String selectionStrategy) {
        if (!Utils.isSelectRideDetailsParamsValid(riderName, source, destination, seats, selectionStrategy)) {
            throw new InvalidSelectRideRequestParamsException("Invalid request params in case of select ride");
        }

        // filter offered ride details list satisfying minimum conditions
        // i.e requested source and destination,  available seats >= seats requested, ride status is offered.
        final List<RideDetails> filterOfferedRideDetailList
                = Utils.getActiveRideDetailsList(allActiveRideDetailsList, source, destination, seats);

        final RideDetails mostOptimalRideDetail
                = getMostOptimalRideDetails(filterOfferedRideDetailList, selectionStrategy);

        if (mostOptimalRideDetail == null) {
            // Assumptions for solving bonus questions : not taking into account selectionStrategy feature.
            // If direct path does not exist then checking whether indirect path if yes returning chain of vehicleNos.
            return getIndirectRideDetailsPath(riderName, source, destination, seats);
        }

        mostOptimalRideDetail.setRiderName(riderName);
        mostOptimalRideDetail.setRideStatus(RideStatus.SELECTED);
        return mostOptimalRideDetail.getVehicleNo();
    }

    /**
     * Function to handle end ride.
     *
     * @param vehicleNo
     */
    public void endRide(String vehicleNo) {
        if (vehicleNo == null) {
            throw new InvalidEndRideRequestParamsException("Invalid request params in case of ending ride");
        }

        if (!activeRideDetailsMap.containsKey(vehicleNo)) {
            throw new RideNotFoundException("Ride has not been offered");
        }
        final RideDetails rideDetails = activeRideDetailsMap.get(vehicleNo);
        rideDetails.setRideStatus(RideStatus.ENDED);

        // Updating ride offered count map.
        final String rideOwner = rideDetails.getVehicleOwner();
        Integer initialRideOfferedCount = userNameToRideOfferedCountMap.computeIfAbsent(rideOwner, k -> 0);
        userNameToRideOfferedCountMap.put(rideOwner, initialRideOfferedCount + 1);

        // Updating ride taken count map.
        final String riderName = rideDetails.getRiderName();
        Integer initialRideTakenCount = userNameToRideTakenMap.computeIfAbsent(riderName, k -> 0);
        userNameToRideTakenMap.put(riderName, initialRideTakenCount + 1);

        // As ride has ended hence remove from activeRideDetailsMap and allActiveRideDetailsList.
        activeRideDetailsMap.remove(vehicleNo);
        allActiveRideDetailsList.remove(rideDetails);
    }

    /**
     * Function to print rideOffered count and rideTaken count corresponding to each userName.
     *
     */
    public String printRideStats() {
        final StringBuilder rideStats = new StringBuilder();
        userList.stream().filter(Objects::nonNull).forEach((user) -> {
            final Integer rideTakenCount = userNameToRideTakenMap.computeIfAbsent(user.getName(), k -> 0);
            final Integer rideOfferedCount = userNameToRideOfferedCountMap.computeIfAbsent(user.getName(), k -> 0);
            rideStats.append(String.format("%s : %d Taken, %d Offered\n", user.getName(), rideTakenCount, rideOfferedCount));
        });

        return rideStats.toString();
    }

    /**
     * Function to fetch indirect ride details path from offered ride details.
     *
     * @param riderName
     * @param source
     * @param destination
     * @param seats
     * @return source -> intermediate1 -> intermediate2 -> ........ -> destination
     */
    private String getIndirectRideDetailsPath
            (final String riderName,
             final String source,
             final String destination,
             final Integer seats) {
        final Map<String, List<RideDetails>> sourceToDestinationOfferedRideDetailsMap
                = Utils.getSourceToDestinationOfferedRideDetailsMap(allActiveRideDetailsList, seats);

        final Stack<RideDetails> desiredRideDetailStack = new Stack<>();
        final Map<String, Boolean> visitedMap = new HashMap<>();

        // Calling recursion function to check whether there exists some path
        // and recursive function will populate Stack desiredRideDetailStack
        if (Utils.dfsToFindPathFromSourceToDestination(
                sourceToDestinationOfferedRideDetailsMap,
                visitedMap,
                source,
                destination,
                desiredRideDetailStack)) {

            // Only considering path of length > 1 because in bonus question not taking into account selectionStrategy
            // if path of length 1 exist it would have been considered in simple scenario.
            if (desiredRideDetailStack.size() == 1) {
                return null;
            }

            final List<String> indirectPath = new ArrayList<>();
            while (!desiredRideDetailStack.empty()) {
                final RideDetails rideDetails = desiredRideDetailStack.pop();
                rideDetails.setRiderName(riderName);
                rideDetails.setRideStatus(RideStatus.SELECTED);
                // Adding current path.
                indirectPath.add(rideDetails.getVehicleNo());
            }

            Collections.reverse(indirectPath);
            // path is in form of source -> intermediate1 -> intermediate2 -> ..... -> destination
            return indirectPath
                    .stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.joining(" -> "));
        }

        return null;
    }

    /**
     * Private function to fetch most optimal ride details.
     *
     * @param filterOfferedRideDetailList
     * @param selectionStrategy: takes value 'Most_Vacant' if most vacant vehicle is preferred otherwise name of vehicle.
     * @return
     */
    private RideDetails getMostOptimalRideDetails(
            final List<RideDetails> filterOfferedRideDetailList,
            final String selectionStrategy) {

        if (filterOfferedRideDetailList == null || filterOfferedRideDetailList.size() == 0) {
            return null;
        }

        if (MOST_VACANT.equalsIgnoreCase(selectionStrategy)) {
            // Need to find ride which is most vacant.
            return filterOfferedRideDetailList
                    .stream()
                    .max(Comparator.comparing(RideDetails::getAvailableSeats))
                    .orElse(filterOfferedRideDetailList.get(0));
        }

        // Need to find any ride where preferred vehicleName is selectionStrategy
        return filterOfferedRideDetailList
                .stream()
                .filter((rideDetails -> rideDetails.getVehicleName().equalsIgnoreCase(selectionStrategy)))
                .findFirst()
                .orElse(null);
    }
}
