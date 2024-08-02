# Adding a product with productType "dye"
curl -X POST "http://localhost:8080/api/v1/product/saveProduct" \
     -H "Content-Type: application/json" \
     -d '{
           "productId": "00",
           "productName": "Red Dye",
           "productType": "dye"
         }'

# Adding a product with productType "dye"
curl -X POST "http://localhost:8080/api/v1/product/saveProduct" \
     -H "Content-Type: application/json" \
     -d '{
           "productId": "00",
           "productName": "Blue Dye",
           "productType": "dye"
         }'

# Adding a product with productType "chemical"
curl -X POST "http://localhost:8080/api/v1/product/saveProduct" \
     -H "Content-Type: application/json" \
     -d '{
           "productId": "00",
           "productName": "Sulfuric Acid",
           "productType": "chemical"
         }'

# Adding a product with productType "chemical"
curl -X POST "http://localhost:8080/api/v1/product/saveProduct" \
     -H "Content-Type: application/json" \
     -d '{
           "productId": "00",
           "productName": "Hydrochloric Acid",
           "productType": "chemical"
         }'




curl --location 'http://localhost:8080/api/v1/recipe/saveRecipe' \
--header 'Content-Type: application/json' \
--data '{
  "reciNo": "00",
  "color": "Blue",
  "labDip": "3",
  "roleCount": "14",
  "weight": "156",
  "liquorRatio": "8",
  "volume": "1092",
  "createdUser": "user123",
  "createdDateTime": "2024-08-01T04:18:06.625Z",
  "recipeDetails": [
    {
      "addFunction": "1",
      "productName": "Red Dye",
      "dose": "0.02",
      "temp": "",
      "time": "",
      "quantityInGrams": "31.2"
    },
    {
      "addFunction": "2",
      "productName": "Blue Dye",
      "dose": "0.17",
      "temp": "",
      "time": "",
      "quantityInGrams": "265.2"
    },
    {
      "addFunction": "3",
      "productName": "Sulfuric Acid",
      "dose": "0.02",
      "temp": "",
      "time": "",
      "quantityInGrams": "31.2"
    },
    {
      "addFunction": "4",
      "productName": "Hydrochloric Acid",
      "dose": "1.3",
      "temp": "",
      "time": "",
      "quantityInGrams": "1419.6"
    }
  ]
}'


