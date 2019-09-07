"""
Common class for both snake and ladder.
Given a source this can tell target.
"""
class Movable():

    def __init__(self, source, target):
        self.__source = source
        self.__target = target

    def is_source(self, val):
        if self.__source == val:
            return True
        return False

    def get_target(self):
        return self.__target

    def get_source(self):
        return self.__source
