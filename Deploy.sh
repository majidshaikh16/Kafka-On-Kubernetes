docker build -t majidshaikh16/consumer:latest -t majidshaikh16/consumer:$SHA -f ./project/Kafka-Consumer-Prototype/Dockerfile ./project/Kafka-Consumer-Prototype/
docker build -t majidshaikh16/producer:latest -t majidshaikh16/producer:$SHA -f ./project/Kafka-Producer-Prototype/Dockerfile ./project/Kafka-Producer-Prototype/
docker build -t majidshaikh16/food-app:latest -t majidshaikh16/food-app:$SHA -f ./project/food-app/Dockerfile ./project/food-app/

docker push majidshaikh16/consumer:latest
docker push majidshaikh16/producer:latest
docker push majidshaikh16/food-app:latest

docker push majidshaikh16/consumer:$SHA
docker push majidshaikh16/producer:$SHA
docker push majidshaikh16/food-app:$SHA


kubectl apply -f k8s/ingress/
kubectl apply -f k8s/volumes/
kubectl apply -f k8s/db/
kubectl apply -f k8s/kafka/
kubectl apply -f k8s/app/

kubectl set image deployments/consumer-deployment consumer=majidshaikh16/consumer:$SHA
kubectl set image deployments/producer-deployment producer=majidshaikh16/producer:$SHA
kubectl set image deployments/food-app-deployment food-app=majidshaikh16/food-app:$SHA