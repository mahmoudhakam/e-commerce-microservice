E-commerce Microservices architecture

Introduction:

Pre-requisites:
    
    Install docker desktop
    Install maven
    Install java jdk-21 amazoncorrecto distribution

System overview:

System design and architecture:

Functional requirements:

    TBD

Non-functional requirements:

    TBD

Order putting flow:
    
    When create order request is sent to Order Service, a number of microservices are ready to kick start upon receiving the
    corresponding events
    
    Order Service creates and updates orders.
    Warehouse Service reserves/releases stock for orders and creates shipment records.
    Payment Service processes payments and creates invoices.
    Catalogue Service contains product-related information (i.e. products, details, prices)
    Notification Service sends notifications to customers informing them about different order stages
    Customer Service contains customer-related information (i.e. name, contact infromation)
    Each service is responsible for only one function and functions based on receiving and generatings events. Each service
    is independent and is not aware of its neighborhoods.

Home/search flow:

    TBD

Recommendations flow:

    TBD

https://javachallengers.com/design-amazon-e-commerce-systems-design-interview/
https://www.linkedin.com/posts/rocky-bhatia-a4801010_system-design-for-any-e-commerce-website-activity-7122187229250138112-nax7/
https://medium.com/design-microservices-architecture-with-patterns/design-e-commerce-applications-with-microservices-architecture-c69e7f8222e7
https://medium.com/double-pointer/system-design-interview-amazon-flipkart-ebay-or-similar-e-commerce-applications-35a0bc764421
https://medium.com/@vaibhavkansagara/high-level-system-design-for-amazon-1aa18f3efd15

Design considerations:

Technology stack:

    web: Spring Boot - Spring cloud -  - docker - k8s
    jdk: Java 21
    database: PostgreSQL database - Mongo database
    caching: redis cache
    operation: docker
    deployment: jenkins - k8s
    observability: Opentelemetry (otel processing) - Grafana (dashboards) - Prometheus (metrics) - Loki (logging) - Tempo (tracing)

Error Handling and Logging

    Error handling strategies
    Logging mechanisms

Infrastructure considerations:

    Deployment architecture (e.g., cloud-based, on-premises)
    Hardware and network infrastructure
    Load balancing and scaling strategies

Security considerations:

    Authentication mechanisms
    Authorization mechanisms
    Data encryption
    Security protocols

External integrations:

    External systems or services integrated with the system
    APIs and protocols used for integration

Testing Strategy

    Unit testing
    Integration testing
    System testing
    Performance testing
    Security testing

Monitoring and Alerting

    Monitoring tools and techniques
    Alerting mechanisms

Deployment Strategy

    Deployment process
    Rollout strategy
    Environment setup (development, staging, production)

C4 Model for Order putting

Level 1: System Context diagram:

![](.\infrastructure\C4-model-architecture\C4-checkout-system-context.svg)

Level 2: Container diagram
TBD

Level 3: Component diagram:
TBD

Level 4: Code diagram:
TBD

Dynamic diagram:

    Request flow for order management
    
    State diagram for order management

    Event storming diagram

Observability diagram:
TBD

Deployment diagram:
TBD

How to run:

How to run local infrastructure:
Make sure that you have make installed on your machine, if you are on windows ''' choco install make '''
go to the base project, then run
``` make install-infrastructure ```

and then inside each service run ``` make ${servicename}``` to be replaced by names inside Makefile inside each service