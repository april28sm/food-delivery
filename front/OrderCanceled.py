
from AbstractEvent import AbstractEvent
import json

class OrderCanceled(AbstractEvent):
    id : int
    foodId : str
    customerId : str
    preference : str
    
    def __init__(self):
        super().__init__()
        self.id = None
        self.foodId = None
        self.customerId = None
        self.preference = None

