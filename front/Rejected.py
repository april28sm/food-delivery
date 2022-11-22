
from AbstractEvent import AbstractEvent
import json

class Rejected(AbstractEvent):
    id : int
    orderId : str
    foodId : str
    
    def __init__(self):
        super().__init__()
        self.id = None
        self.orderId = None
        self.foodId = None

