## Hello test
curl -X 'GET' \
  'http://localhost:8051/hello' \
-H 'accept: */*'

## Test span id and trace id through order notification integration
curl -X 'GET' \
  'http://localhost:8051/notify' \
  -H 'accept: */*'

## Hello test
curl -X 'GET' \
  'http://localhost:8051/hello' \
-H 'accept: */*'

## Test span id and trace id through order notification integration
curl -X 'GET' \
  'http://localhost:8051/notify' \
  -H 'accept: */*'

