INSERT INTO customers (customer_id, full_name, email, risk_level, home_country, avg_transaction_amount)
VALUES
('cust_1001', 'Alice Johnson', 'alice@example.com', 'LOW', 'USA', 120.50),
('cust_1002', 'Bob Smith', 'bob@example.com', 'MEDIUM', 'USA', 340.00)
ON CONFLICT (customer_id) DO NOTHING;

INSERT INTO devices (device_id, customer_id, device_fingerprint, trusted_flag)
VALUES
('dev_2001', 'cust_1001', 'fingerprint-alice-1', TRUE),
('dev_2002', 'cust_1002', 'fingerprint-bob-1', FALSE)
ON CONFLICT (device_id) DO NOTHING;

INSERT INTO merchant_profiles (merchant_id, merchant_name, merchant_category, risk_rating, blacklisted_flag)
VALUES
('merch_3001', 'Amazon', 'E-Commerce', 'LOW', FALSE),
('merch_3002', 'Unknown Electronics', 'Electronics', 'HIGH', TRUE)
ON CONFLICT (merchant_id) DO NOTHING;
