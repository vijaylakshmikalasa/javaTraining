<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=5.0">
    <title>Login Page</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-blue-500 flex items-center justify-center h-screen">
    <div class="max-w-md w-full bg-white p-6 rounded-md shadow-md">
        <h2 class="text-2xl font-semibold text-center mb-6">Login</h2>
        <form action="login" method="post">
            <div class="mb-4">
                <label for="name" class="block text-gray-700 text-sm font-bold mb-2">Name</label>
                <input type="text" id="name" name="name" class="border border-black-300 p-2 rounded w-full" required>
            </div>
            <div class="mb-6">
                <label for="password" class="block text-black-700 text-sm font-bold mb-2">Password</label>
                <input type="password" id="password" name="pass" class="border border-black-500 p-2 rounded w-full" required>
            </div>
            <button type="submit" class="bg-blue-500 text-white p-2 rounded w-full hover:bg-black-600">Login</button>
        </form>
    </div>
 
    <script src="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.js"></script>
</body>
</html>