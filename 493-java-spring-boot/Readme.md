# 493
```bash

cd 493-java-spring-boot/

./build.sh
./push.sh

# importaljuk a yaml fajlokat
kubectl apply -f .kube/

# válasszuk ki a cafe-shop namespace-t
kubens cafe-shop

# deploymentek lekerdezese
kubectl get deploy

# service-ek lekerdezese
kubectl get service

# namespacen belul minden lekerdezese
kubectl get all

# ingress lekerdezese
kubectl get ingress

# reszletes adatok az ingressrol
kubectl describe ingress/shop.127.0.0.1.xip.io

http://shop.127.0.0.1.xip.io/tea
https://shop.127.0.0.1.xip.io/tea
Refresh x5

# scale fel 3-ra
kubectl scale deployment.v1.apps/tea-deployment --replicas=3

https://shop.127.0.0.1.xip.io/tea
Refresh x5

# takaritas
kubectl delete ns cafe-shop
```