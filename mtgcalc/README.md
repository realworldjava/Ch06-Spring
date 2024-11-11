Following is a sample request.json payload for the Spring Boot MVC project:   
Request type: POST  
URL: http://localhost:8081/mtg/payment  
Json Body:
```json
[
  {
    "user": {
      "name": "John Jones",
      "location": "Miami, Florida"
    },
    "principal": 250000,
    "years": 30,
    "interest": 6.5
  },
  {
    "user": {
      "name": "Mary Michaels",
      "location": "New York, NY"
    },
    "principal": 100000,
    "years": 30,
    "interest": 6.25
  }
]
```