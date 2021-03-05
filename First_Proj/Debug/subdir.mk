################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../Ladder.cpp \
../Player.cpp \
../Service.cpp \
../Snake.cpp \
../SnakeandLadderboard.cpp \
../main.cpp 

OBJS += \
./Ladder.o \
./Player.o \
./Service.o \
./Snake.o \
./SnakeandLadderboard.o \
./main.o 

CPP_DEPS += \
./Ladder.d \
./Player.d \
./Service.d \
./Snake.d \
./SnakeandLadderboard.d \
./main.d 


# Each subdirectory must supply rules for building sources it contributes
%.o: ../%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


