start-mongo: ## Run mongo database
	@docker compose -f .\infrastructure\mongo-compose.yml --env-file .\infrastructure\db-scripts\mongo\.env --compatibility up --build -d --wait

start-kafka: ## Run kafka cluster
	@docker compose -f .\infrastructure\kafka-compose-v1.yml --compatibility up --build -d --wait

start-observability: ## Run opentelemetry grafana prometheus loki tempo for observability
	@docker compose -f .\infrastructure\observability-compose.yaml --compatibility up --build -d --wait

start-postgres-redis: ## Run postgres redis
	@docker compose -f .\infrastructure\postgres-redis-compose.yml --compatibility up --build -d --wait

start-nginx: ## Run postgres redis
	@docker compose -f .\infrastructure\nginx\nginx-compose.yml --compatibility up --build -d --wait

start-infrastructure: ## Run all infrastructure
	echo "install-infrastructure"
	$(MAKE) start-mongo start-kafka start-observability start-postgres-redis start-nginx

start-all-services:
	cd .\infrastructure\docker-containers && $(MAKE) start-order-svc
	cd .\infrastructure\docker-containers && $(MAKE) start-notification-svc
	cd .\infrastructure\docker-containers && $(MAKE) start-payment-svc
	cd .\infrastructure\docker-containers && $(MAKE) start-product-svc
	cd .\infrastructure\docker-containers && $(MAKE) start-customer-svc
	cd .\infrastructure\docker-containers && $(MAKE) start-shopping-svc
	cd .\infrastructure\docker-containers && $(MAKE) start-warehouse-svc
	cd .\infrastructure\docker-containers && $(MAKE) start-edge-svc
	cd .\infrastructure\docker-containers && $(MAKE) start-sso-svc