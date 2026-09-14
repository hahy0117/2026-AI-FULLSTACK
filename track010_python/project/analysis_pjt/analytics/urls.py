
from django.urls import path
from . import views

urlpatterns=[
    #http://127.0.0.1:8000/dashboard/ 요청시 view.py 의 dashboard_vies 연결
    # 기본경로,해결사 :처리 .dashboard_view ,이름
    path('',views.dashboard_view,name='dashboard'),
    path('api/statistics/', views.api_receive_statistics, name='api_receive_statistics'),
]
