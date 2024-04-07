start-order-svc:
	cd ..\..\order-managment-svc && @mvn clean install -DskipTests
	cd ..\..\order-managment-svc && @docker compose up --build -d

start-notification-svc:
	cd ..\..\notification-managment-svc && @mvn clean install -DskipTests
	cd ..\..\notification-managment-svc && @docker compose up --build -d

start-payment-svc:
	cd ..\..\payment-managment-svc && @mvn clean install -DskipTests
	cd ..\..\payment-managment-svc && @docker compose up --build -d

start-customer-svc:
	cd ..\..\customer-managment-svc && @mvn clean install -DskipTests
	cd ..\..\customer-managment-svc && @docker compose up --build -d

start-product-svc:
	cd ..\..\product-managment-svc && @mvn clean install -DskipTests
	cd ..\..\product-managment-svc && @docker compose up --build -d

start-shopping-svc:
	cd ..\..\shopping-cart-svc && @mvn clean install -DskipTests
	cd ..\..\shopping-cart-svc && @docker compose up --build -d

start-warehouse-svc:
	cd ..\..\warehouse-managment-svc && @mvn clean install -DskipTests
	cd ..\..\warehouse-managment-svc && @docker compose up --build -d

start-edge-svc:
	cd ..\..\edge-gateway-svc && @mvn clean install -DskipTests
	cd ..\..\edge-gateway-svc && @docker compose up --build -d

start-sso-svc:
	cd ..\..\sso-authentication-svc && @mvn clean install -DskipTests
	cd ..\..\sso-authentication-svc && @docker compose up --build -d