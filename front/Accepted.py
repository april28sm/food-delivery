
from AbstractEvent import AbstractEvent
import json

class Accepted(AbstractEvent):
    id : int
    foodId : str
    orderId : int
    status : str
    
    def __init__(self):
        super().__init__()
        self.id = None
        self.foodId = None
        self.orderId = None
        self.status = None

