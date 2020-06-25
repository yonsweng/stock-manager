from django.urls import path
from django.conf.urls import url, include
from django.contrib import admin
from rest_framework import routers
from core.views import ItemViewSet
from . import views

router = routers.DefaultRouter()
router.register('', ItemViewSet)

urlpatterns = [
    url(r'^admin/', admin.site.urls),
    url(r'^', include(router.urls)),
]
