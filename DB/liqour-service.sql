CREATE DATABASE IF NOT EXISTS product;
USE product;

DROP TABLE IF EXISTS bottles;

CREATE TABLE bottles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    category VARCHAR(100),
    volume INT UNSIGNED, 
    price DECIMAL(10,2),
    image_name VARCHAR(255),
    image_type VARCHAR(50),
    image_data LONGBLOB
);

INSERT INTO bottles (name, description, category, volume, price, image_name, image_type, image_data)
VALUES 
('Jack Daniel\'s Tennessee Whiskey', 'A smooth, charcoal-mellowed whiskey aged in handcrafted barrels.', 'Whiskey', 750, 5000.00, 'b1.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b1.png")),
('VAT 9 Whiskey', 'A premium blended Scotch whisky with a rich and smoky flavor.', 'Whiskey', 750, 7000.00, 'b2.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b2.png")),
('VX Whiskey', 'A premium whiskey with a bold and smooth flavor.', 'Whiskey', 700, 7800.00, 'b3.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b3.png")),
('Loch Lomond Rum', 'A smooth and refreshing white rum, perfect for cocktails.', 'Rum', 750, 1180.00, 'b4.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b4.png")),
('Old Arrack Whiskey', 'A well-balanced Scottish whisky with hints of fruit and oak.', 'Whiskey', 700, 9500.00, 'b5.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b5.png")),
('Old Arrack Brandy', 'A rich and smooth brandy aged to perfection.', 'Brandy', 750, 8800.00, 'b6.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b6.png")),
('Halmilla Brandy', 'A traditional Sri Lankan arrack with a distinct taste.', 'Arrack', 700, 5800.00, 'b7.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b7.png")),
('Rockland Brandy', 'A rich and flavorful brandy with hints of vanilla and spice.', 'Brandy', 700, 28000.00, 'b8.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b8.png")),
('Paradise Vodka', 'A unique and aromatic liqueur with a sweet finish.', 'Vodka', 750, 7800.00, 'b9.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b9.png")),
('OLD KEG Whisky', 'A crystal-clear vodka with a smooth and crisp taste.', 'Whiskey', 750, 3500.00, 'b10.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b10.png")),
('Navy Seal Vodka', 'A premium whisky with a rich and smoky finish.', 'Vodka', 700, 18000.00, 'b11.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b11.png")),
('ROSKAA Rum', 'A Caribbean spiced rum with hints of vanilla and caramel.', 'Rum', 750, 6800.00, 'b12.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b12.png")),
('Twist VODKA', 'A smooth and premium vodka with a crisp finish.', 'Vodka', 700, 7800.00, 'b13.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b13.png")),
('Rockland Red Rum', 'A high-quality dark rum with rich caramel and spice notes.', 'Rum', 750, 2900.00, 'b14.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b14.png")),
('Rockland Liqueurs', 'A smooth and pure vodka distilled from the finest grains.', 'Liqueurs', 750, 5200.00, 'b15.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b15.png")),
('Colombo 8 Gin', 'A classic dry gin with rich botanical flavors.', 'Gin', 700, 45000.00, 'b16.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b16.png")),
('Colombo 7 Gin', 'A premium Sri Lankan gin with a unique spice blend.', 'Gin', 750, 5700.00, 'b17.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b17.png")),
('Angel Vodka', 'A premium vodka with a clean and crisp taste.', 'Vodka', 700, 4200.00, 'b18.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b18.png")),
('ROCKLAND THREE STAR Brandy', 'A rich and smooth brandy with hints of oak.', 'Brandy', 700, 3000.00, 'b19.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b19.png")),
('Old Arrack Brandy', 'A traditional Sri Lankan arrack with a smooth finish.', 'Arrack', 750, 8500.00, 'b20.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b20.png")),
('Tall Horse Wine', 'A South African wine with a rich and fruity taste.', 'Wine', 750, 2500.00, 'b21.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b21.png")),
('Hardy\'s Wine', 'An Australian red wine with bold and robust flavors.', 'Wine', 750, 3000.00, 'b22.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b22.png")),
('Old Wine', 'A well-aged red wine with a smooth and balanced taste.', 'Wine', 750, 4000.00, 'b23.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b23.png")),
('Santa Cristina Wine', 'An Italian wine with floral aromas and a crisp finish.', 'Wine', 750, 4500.00, 'b24.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b24.png")),
('Old Sea Wine', 'A vintage wine with rich fruit and oak notes.', 'Wine', 750, 5000.00, 'b25.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b25.png")),
('King Absinthe', 'A South African wine with a rich and fruity taste.', 'Absinthe', 750, 5000.00, 'b27.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b26.png")),
('Super Absinthe', 'A vintage wine with rich fruit and oak notes.', 'Absinthe', 750, 5000.00, 'b28.png', 'image/png', LOAD_FILE("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\b27.png"));
