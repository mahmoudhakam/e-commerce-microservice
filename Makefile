start-mongo: ## Run mongo database
	@docker compose -f .\infrastructure\mongo-compose.yml --env-file .\infrastructure\db-scripts\mongo\.env up --build -d --wait

start-kafka: ## Run kafka cluster
	@docker compose -f .\infrastructure\kafka-compose-v1.yml up --build -d --wait

start-observability: ## Run opentelemetry grafana prometheus loki tempo for observability
	@docker compose -f .\infrastructure\observability-compose.yaml up --build -d --wait

start-postgres-redis: ## Run postgres redis
	@docker compose -f .\infrastructure\postgres-redis-compose.yml up --build -d --wait

install-infrastructure: ## Run all infrastructure
	echo "install-infrastructure"
	$(MAKE) start-mongo start-kafka start-observability start-postgres-redis