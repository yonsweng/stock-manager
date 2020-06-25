from django.shortcuts import render
from django.http import HttpResponse
from rest_framework import viewsets
from .serializers import ItemSerializer
from .models import Item


class ItemViewSet(viewsets.ModelViewSet):
    queryset = Item.objects.all()
    serializer_class = ItemSerializer


# def main(request):
#     return HttpResponse('hello world')
