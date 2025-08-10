🚀 𝗦𝘁𝗲𝗽𝗽𝗶𝗻𝗴 𝗶𝗻𝘁𝗼 𝘁𝗵𝗲 𝗪𝗼𝗿𝗹𝗱 𝗼𝗳 𝗦𝗰𝗮𝗹𝗮𝗯𝗹𝗲 𝗕𝗮𝗰𝗸𝗲𝗻𝗱 𝗦𝘆𝘀𝘁𝗲𝗺𝘀 – 𝗠𝘆 𝗙𝗶𝗿𝘀𝘁 𝗠𝗶𝗰𝗿𝗼𝘀𝗲𝗿𝘃𝗶𝗰𝗲𝘀 𝗣𝗿𝗼𝗷𝗲𝗰𝘁!


I recently completed building a 𝗤𝘂𝗶𝘇 𝗔𝗽𝗽𝗹𝗶𝗰𝗮𝘁𝗶𝗼𝗻 using Microservices Architecture — a project where I reimagined and refactored my earlier Monolithic codebase into a cleaner, modular, and production-style backend system. 💻

🛠️ Here's a quick overview of the architecture:

🧠 Quiz Service
Handles quiz creation and logic, and dynamically fetches questions via API calls to the Question Service.

❓ Question Service
A dedicated microservice for managing and serving questions, deployed in multiple instances (ports `8080` & `8081`) to ensure better scalability and load distribution.

🛡️ API Gateway 
All client requests are routed through a single entry point using Spring Cloud Gateway.

🧭 Netflix Eureka Server 
Used for automatic service discovery and load balancing across instances.

🔗 OpenFeign
Enables declarative, REST-based inter-service communication between the quiz and question services.

📮 Postman
Used extensively for testing APIs, simulating client requests, and verifying end-to-end communication.

🗃️ MySQL
Used as the database for both services — with separate databases (`quizdb` & `questiondb`) to ensure independent data ownership and loose coupling.


⚙️ Technologies Used :

- Java 21 
- Spring Boot 
- Spring Cloud Gateway 
- Spring Cloud Netflix Eureka 
- Spring Cloud OpenFeign 
- MySQL (`quizdb`, `questiondb`) 
- Maven 
- IntelliJ IDEA 
- Postman for API testing and request/response verification

💬 𝗠𝗶𝗰𝗿𝗼𝘀𝗲𝗿𝘃𝗶𝗰𝗲𝘀 𝗜𝗻𝘁𝗲𝗿𝗮𝗰𝘁𝗶𝗼𝗻 𝗙𝗹𝗼𝘄 - 
 
𝗤𝘂𝗶𝘇 𝗦𝗲𝗿𝘃𝗶𝗰𝗲 ↔️ 𝗤𝘂𝗲𝘀𝘁𝗶𝗼𝗻 𝗦𝗲𝗿𝘃𝗶𝗰𝗲 
- Quiz Service fetches questions from Question Service during quiz creation. 
- Communication happens via OpenFeign client, with service discovery via Eureka.
𝗖𝗹𝗶𝗲𝗻𝘁 ↔️ 𝗤𝘂𝗶𝘇 & 𝗤𝘂𝗲𝘀𝘁𝗶𝗼𝗻 𝗦𝗲𝗿𝘃𝗶𝗰𝗲𝘀 (𝘃𝗶𝗮 𝗔𝗣𝗜 𝗚𝗮𝘁𝗲𝘄𝗮𝘆) 
- All external requests go through the API Gateway, which forwards them to the appropriate microservice. 
- Example Flow: 
 `Client → API Gateway → Quiz Service → Question Service (via Feign)`


✨ As someone still early in my development journey, this project was both a learning experience and a personal milestone. 
I'm proud of how far I’ve come — and excited to keep exploring deeper into the world of distributed systems and scalable backend architecture.

📂 GitHub Repository: 
👉Microservice
[https://lnkd.in/gehcsQpk
](https://github.com/KhamisAbdelzain/Quiz-Application-with-Microservices/tree/main)
👉Monolithic
[https://lnkd.in/gp4gtK-5
](https://github.com/KhamisAbdelzain/Quiz-Application)
