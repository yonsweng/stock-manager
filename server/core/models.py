from django.db import models
from pymongo import MongoClient


class MongoConnection(object):
    def __init__(self):
        client = MongoClient('localhost', 27017)
        self.db = client['stock']
        print(self.db)


class ItemCollection(MongoConnection):
    def __init__(self):
        super(ItemCollection, self).__init__()
        self.collection = self.db['item']
        print(self.collection)

    def get(self, id_):
        return self.collection.find({'id': id_})

    def insert(self, obj):
        print('insert', obj)
        if self.collection.find({'id': obj['id']}).count():
            self.collection.update({'id': obj['id']}, obj)
        else:
            self.collection.insert_one(obj)

    def delete(self, obj):
        if self.collection.find({'id': obj['id']}).count():
            self.collection.delete_one({'id': obj['id']})


class Item(models.Model):
    id = models.IntegerField(primary_key=True)
    name = models.CharField(max_length=30)
    price = models.IntegerField()
    count = models.IntegerField()
