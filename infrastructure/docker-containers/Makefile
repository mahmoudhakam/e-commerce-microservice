start-order-svc:
	cd ..\..\order-managment-svc && @mvn clean install -DskipTests
	cd ..\..\order-managment-svc && @docker compose up --build -d

start-notification-svc:
	cd ..\..\notification-managment-svc && @mvn clean install -DskipTests
	cd ..\..\notification-managment-svc && @docker compose up --build -d