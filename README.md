Respawn 🎮
🚀 Overview
Respawn is a Chrome extension designed for gamers to resolve missing DLL file issues that can occur during game downloads. By allowing users to input the required DLL file name, Respawn simplifies the process of downloading DLLs, ensuring a smooth gaming experience! 🕹️
✨ Features

📝 Manual DLL Input: Users can specify the missing DLL file name for targeted downloads.
📥 Seamless Downloads: Sources safe and reliable DLL files with a single click.
🎨 User-Friendly Interface: Sleek and intuitive UI built with React.js and Vite.
⚡ High Performance: Powered by Spring Boot, Redis, and MongoDB for fast, scalable backend operations.

🛠️ Tech Stack

Frontend: React.js + Vite ⚛️
Backend: Spring Boot ☕
Database: MongoDB 🍃
Caching: Redis 🗄️
Containerization: Docker 🐳

🏁 Getting Started
📋 Prerequisites

Node.js (v16 or higher) 🌐
Java 17 ☕
Docker 🐳
MongoDB 🍃
Redis 🗄️
Git 📂

⚙️ Installation

Clone the Repository:
git clone https://github.com/username/respawn.git
cd respawn


Frontend Setup (React.js + Vite):
cd frontend
npm install
npm run dev

🚀 Frontend runs at http://localhost:5173.

Backend Setup (Spring Boot):

Ensure MongoDB and Redis are running (locally or via Docker).
Navigate to the backend folder:cd backend
mvn clean install
mvn spring-boot:run



🌐 Backend runs at http://localhost:8080.

Docker Setup:

Build and run with Docker Compose:docker-compose up --build





🔧 Configuration

MongoDB: Update backend/src/main/resources/application.properties with MongoDB connection details. 🍃
Redis: Configure Redis connection in application.properties. 🗄️
Environment Variables: Set .env in the frontend folder (e.g., VITE_API_URL=http://localhost:8080). ⚙️

🎮 Usage

Build the Chrome extension: npm run build in the frontend folder to generate the dist folder.
Load the extension in Chrome via Developer Mode (chrome://extensions/).
Enter the name of the missing DLL file in the Respawn extension, and it will guide you to download it! 🕹️

🤝 Contributing
We love contributions! To join the Respawn team:

Fork the repository 🍴
Create a feature branch: git checkout -b feature/your-feature 🌿
Commit changes: git commit -m "Add your feature" 💾
Push to the branch: git push origin feature/your-feature 🚀
Open a Pull Request 📬
