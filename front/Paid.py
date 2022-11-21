from AbstractEvent import AbstractEvent
import json
from datetime import datetime

class Paid(AbstractEvent):
    id : int
    orderId : str
    
    def __init__(self):
        super().__init__()
        self.id = None
        self.orderId = None

