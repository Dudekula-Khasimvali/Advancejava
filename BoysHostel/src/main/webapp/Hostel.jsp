<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hostel Homepage</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <div class="hostel" id="hostelA" onclick="showDetails('Hostel A', 'Location A', 'Capacity: 100', 'Facilities: Wi-Fi, Gym, Mess')">
            <h2>Hostel A</h2>
            <p>Location A</p>
            <p>Capacity: 100</p>
            <p>Facilities: Wi-Fi, Gym, Mess</p>
        </div>
        <div class="hostel" id="hostelB" onclick="showDetails('Hostel B', 'Location B', 'Capacity: 150', 'Facilities: Study Hall, Playground')">
            <h2>Hostel B</h2>
            <p>Location B</p>
            <p>Capacity: 150</p>
            <p>Facilities: Study Hall, Playground</p>
        </div>
        <div class="hostel" id="hostelC" onclick="showDetails('Hostel C', 'Location C', 'Capacity: 120', 'Facilities: Indoor Games, TV Room')">
            <h2>Hostel C</h2>
            <p>Location C</p>
            <p>Capacity: 120</p>
            <p>Facilities: Indoor Games, TV Room</p>
        </div>
    </div>
    <script src="script.js"></script>
</body>
</html>
