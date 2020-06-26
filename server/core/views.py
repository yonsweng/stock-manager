from django.http import HttpResponse
from django.views.decorators.csrf import csrf_exempt
from .models import ItemCollection
import json

item_collection = ItemCollection()


@csrf_exempt
def main(request):
    if request.method == 'GET':
        item = item_collection.get(int(request.GET['id']))
        return HttpResponse(item, status=200)

    elif request.method == 'POST':
        item_dict = json.loads(request.body)
        print(item_dict)
        item_collection.insert(item_dict)
        return HttpResponse('posted', status=201)
