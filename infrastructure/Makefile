SHELL := /bin/bash
.PHONY: test install run help

start-mongo: ## Run API with docker compose
	@docker compose -f mongo-compose.yml --env-file ./dbdb-scripts/mongo/.env up --build -d --wait