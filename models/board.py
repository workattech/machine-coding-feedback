class Board:
    """Board class representing the snake and ladder board.
    """
    
    def __init__(self) -> None:
        self.cell_objects = {}

    def register_cell_object(self, start_cell: int, end_cell: int, object_type):
        """Construct the board by using the snakes and ladder.

        Args:
            start_cell (int): starting cell
            end_cell (int): ending cell
            object_type (_type_): whether the object was a snake or ladder
        """

        if object_type == "snake" and end_cell >= start_cell:
            raise Exception("For snake end cell should be lesser then start cell")
        if object_type == "ladder" and end_cell <= start_cell:
            raise Exception("For ladder end cell should be greater then start cell")

        self.cell_objects[start_cell] = {"destination_cell": end_cell, "type": object_type}