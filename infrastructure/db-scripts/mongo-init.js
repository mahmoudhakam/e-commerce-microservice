db.createUser(
    {
        user: "appusr",
        pwd: "appdev",
        roles: [
            {
                role: "readWrite",
                db: "orders-db"
            },
            {
                role: "readWrite",
                db: "warehouse-db"
            },
            {
                role: "readWrite",
                db: "customer-db"
            }
        ]
    }
);