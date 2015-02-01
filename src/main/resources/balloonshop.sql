-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 01, 2015 at 05:56 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `balloonshop`
--

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `description`, `name`) VALUES
(1, 'Here''s our collection of balloons with romantic messages.', 'Love & Romance'),
(2, 'Tell someone "Happy Birthday" with one of these wonderful balloons!', 'Birthdays'),
(3, 'Going to a wedding? Here''s a collection of balloons for that special event!', 'Weddings'),
(4, 'Why write on paper, when you can deliver your message on a balloon?', 'Message Balloons'),
(5, 'Buy a balloon with your child''s favorite cartoon character!', 'Cartoons'),
(6, 'Various baloons that your kid will most certainly love!', 'Miscellaneous'),
(8, 'All your favorite movie characters.', 'Movies'),
(9, 'Get your famous person like a balloon head :D ', 'Celebrities');

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `description`, `fileLargeImage`, `fileSmallImage`, `largeImage`, `name`, `onPromotion`, `price`, `smallImage`) VALUES
(1, 'An adorable romantic balloon by Simon Elvin. You''ll fall in love with the cute bear bearing a bouquet of roses, a heart with I Love You, and a card.', NULL, NULL, '0326801.jpg', 'I Love You (Simon Elvin)', 0, 121.99, 't0326801.jpg'),
(2, 'A heart shaped balloon with the great Elvis on it and the words "You''re My Hunka Hunka Burnin'' Love!". Also a copy of the Kings Signature.', NULL, NULL, '16110p.jpg', 'Elvis Hunka Burning Love', 0, 12.99, 't16110p.jpg'),
(3, 'A red heart-shaped balloon with "I love you" written on a white heart surrounded by cute little hearts and flowers.', NULL, NULL, '16162p.jpg', 'Funny Love', 0, 12.99, 't16162p.jpg'),
(4, 'White heart-shaped balloon with the words "Today, Tomorrow and Forever" surrounded with red hearts of varying shapes. "I Love You" appears at the bottom in a red heart.', NULL, NULL, '16363p.jpg', 'Today, Tomorrow & Forever', 0, 12.99, 't16363p.jpg'),
(5, 'Red heart-shaped balloon with a smiley face. Perfect for saying I Love You!', NULL, NULL, '16744p.jpg', 'Smiley Heart Red Balloon', 0, 12.99, 't16744p.jpg'),
(6, 'A red heart-shaped balloon with "I Love You" in script writing. Gold heart outlines adorn the background.', NULL, NULL, '16756p.jpg', 'Love 24 Karat', 0, 12.99, 't16756p.jpg'),
(7, 'Red heart-shaped balloon with a smiley face and three kisses. A perfect gift for Valentine''s Day!', NULL, NULL, '16864p.jpg', 'Smiley Kiss Red Balloon', 0, 12.99, 't16864p.jpg'),
(8, 'A balloon with a simple message of love. What can be more romantic?', NULL, NULL, '16967p.jpg', 'Love You Hearts', 0, 12.99, 't16967p.jpg'),
(9, 'A heart-shaped balloon with a picture of the King himself-Elvis Presley. This must-have for any Elvis fan has "Love Me Tender" written on it with a copy of Elvis''s signature.', NULL, NULL, '16973p.jpg', 'Love Me Tender', 0, 12.99, 't16973p.jpg'),
(10, 'When you just can''t get enough of someone, this Austin Powers style balloon says it all.', NULL, NULL, '16974p.jpg', 'I Can''t Get Enough of You Baby', 0, 12.99, 't16974p.jpg'),
(11, 'A red heart-shaped balloon with a cute picture of two children kissing on a swing.', NULL, NULL, '16980p.jpg', 'Picture Perfect Love Swing', 0, 12.99, 't16980p.jpg'),
(12, 'A white heart-shaped balloon has "I Love You" written on it and is beautifully decorated with two flowers, a small red heart in the middle, and miniature hearts all around.', NULL, NULL, '214006p.jpg', 'I Love You Roses', 0, 12.99, 't214006p.jpg'),
(13, 'A romantic red heart-shaped balloon with "I Love You" in white. What more can you say?', NULL, NULL, '214041p.jpg', 'I Love You Script', 0, 12.99, 't214041p.jpg'),
(14, 'A white heart-shaped balloon with a rose and the words "I Love You." Romantic and irresistible.', NULL, NULL, '214168p.jpg', 'Love Rose', 0, 12.99, 't214168p.jpg'),
(15, 'Tell someone how special he or she is with this lovely heart-shaped balloon with a cute bear holding a flower.', NULL, NULL, '215302p.jpg', 'You''re So Special', 0, 12.99, 't215302p.jpg'),
(16, 'A simple but romantic red heart-shaped balloon with "I Love You" in large script writing.', NULL, NULL, '22849b.jpg', 'I Love You Red Flourishes', 0, 12.99, 't22849b.jpg'),
(17, 'A simple, romantic red heart-shaped balloon with "I Love You" in small script writing.', NULL, NULL, '45093.jpg', 'I Love You Script', 0, 12.99, 't45093.jpg'),
(18, 'A romantic red heart-shaped balloon with hearts and I "Love You."', NULL, NULL, '68841b.jpg', 'Love Cascade Hearts', 0, 12.99, 't68841b.jpg'),
(19, 'Someone special in your life? Let them know by sending this "You''re So Special" balloon!', NULL, NULL, '7004801.jpg', 'You''re So Special', 0, 12.99, 't7004801.jpg'),
(20, 'Romance is in the air with this red heart-shaped balloon. Perfect for the love of your life.', NULL, NULL, '7008501.jpg', 'Love Script', 0, 12.99, 't7008501.jpg'),
(22, 'Roses are red, violets are blue, but this balloon isn''t a romantic balloon at all. Have a laugh, and tease someone older.', NULL, NULL, '16118p.jpg', 'I''m Younger Than You', 0, 12.99, 't16118p.jpg'),
(23, 'Great Birthday Balloons. Available in pink or blue. One side says "Happy Birthday To You" and the other side says  "Birthday Girl" on the Pink Balloon and "Birthday Boy" on the Blue Balloon. Especially great for children''s parties.', NULL, NULL, '26013.jpg', 'Birthday Balloon', 0, 12.99, 't26013.jpg'),
(24, 'Send a birthday message with this delightful star-shaped balloon and make someone''s day!', NULL, NULL, '35732.jpg', 'Birthday Star Balloon', 0, 12.99, 't35732.jpg'),
(25, 'A cute Tweety bird on a blue heart-shaped balloon with stars. Sylvester is in the background, plotting away as usual.', NULL, NULL, '0276001.jpg', 'Tweety Stars', 0, 12.99, 't0276001.jpg'),
(26, 'An unusual heart-shaped balloon with the words "You''re special.".', NULL, NULL, '0704901.jpg', 'You''re Special', 0, 12.99, 't0704901.jpg'),
(27, 'The perfect way to say you''re sorry. Send a thought with this cute bear  balloon.', NULL, NULL, '0707401.jpg', 'I''m Sorry (Simon Elvin) Balloon', 0, 12.99, 't0707401.jpg'),
(28, 'A lovely way to tell your Mom that she''s special. Surprise her with this lovely balloon on her doorstep.', NULL, NULL, '114103p.jpg', 'World''s Greatest Mom', 0, 12.99, 't114103p.jpg'),
(29, 'Big day ahead? Wish someone "Good Luck" with this colorful balloon!', NULL, NULL, '114118p.jpg', 'Good Luck', 0, 12.99, 't114118p.jpg'),
(30, 'Does someone deserve a special pat on the back? This balloon is a perfect way to pass on the message', NULL, NULL, '114208p.jpg', 'Big Congratulations Balloon', 0, 12.99, 't114208p.jpg'),
(31, 'A purple balloon with the simple words "You''re so Special!" on it. Go on, let them know they are special.', NULL, NULL, '16148p.jpg', 'You''re So Special', 0, 12.99, 't16148p.jpg'),
(32, 'A round balloon just screaming out "Thinking of You!"; especially great if you are far away from someone you care for.', NULL, NULL, '16151p.jpg', 'Thinking of You', 0, 12.99, 't16151p.jpg'),
(33, 'A great way to say Welcome Back!', NULL, NULL, '16558p.jpg', 'Welcome Back', 0, 12.99, 't16558p.jpg'),
(34, 'A round balloon with lots and lots of Thank You''s written on it. You''re sure to get the message through with this grateful balloon.', NULL, NULL, '16772p.jpg', 'Words of Thanks', 0, 12.99, 't16772p.jpg'),
(35, 'If someone special is Going away, let this cute puppy balloon tell them they''ll be missed.', NULL, NULL, '16809p.jpg', 'Missed You''ll Be', 0, 12.99, 't16809p.jpg'),
(36, 'A spotty balloon with the words "You''re Appreciated". I bet they''ll appreciate it too!', NULL, NULL, '16988p.jpg', 'You''re Appreciated', 0, 12.99, 't16988p.jpg'),
(37, 'Thinking of someone? Let them know with this thoughtful heart-shaped balloon with flowers in the background.', NULL, NULL, '214046p.jpg', 'Thinking of You', 0, 12.99, 't214046p.jpg'),
(38, 'We all get sick sometimes and need something to cheer us up. Make the world brighter for someone with this Get Well Soon balloon.', NULL, NULL, '21825b.jpg', 'Get Well-Daisy Smiles', 0, 12.99, 't21825b.jpg'),
(39, 'Woody and Buzz from Toy Story, on a round balloon.', NULL, NULL, '0366101.jpg', 'Toy Story', 0, 12.99, 't0366101.jpg'),
(40, 'If you are a Rugrats fan, you''ll be nuts about this purple Rugrats balloon featuring Chucky and Tommy. A definite Nickelodeon Toon favorite.', NULL, NULL, '03944l.jpg', 'Rugrats Tommy & Chucky', 0, 12.99, 't03944l.jpg'),
(41, 'Rugrats balloon featuring Angelica, Chucky, Tommy, and Reptar.', NULL, NULL, '03945L.jpg', 'Rugrats & Reptar Character', 0, 12.99, 't03945L.jpg'),
(42, 'A blue round balloon with the great cartoon pair: Tweety & Sylvester.', NULL, NULL, '0510801.jpg', 'Tweety & Sylvester', 0, 12.99, 't0510801.jpg'),
(43, 'A close-up of Mickey Mouse on a blue heart-shaped balloon. Check out our close-up matching Minnie balloon.', NULL, NULL, '0521201.jpg', 'Mickey Close-up', 0, 12.99, 't0521201.jpg'),
(44, 'A close-up of Minnie Mouse on a pink heart-shaped balloon. Check out our close-up matching Mickey balloon.', NULL, NULL, '0522101.jpg', 'Minnie Close-up', 0, 12.99, 't0522101.jpg'),
(45, 'Time for Teletubbies balloon. Great gift for any kid.', NULL, NULL, '0611401.jpg', 'Teletubbies Time', 0, 12.99, 't0611401.jpg'),
(46, 'Barbie and her friends on a round balloon.', NULL, NULL, '0661701.jpg', 'Barbie My Special Things', 0, 12.99, 't0661701.jpg'),
(47, 'Remember Paddington? A must-have for any Paddington Bear lover.', NULL, NULL, '215017p.jpg', 'Paddington Bear', 0, 12.99, 't215017p.jpg'),
(48, 'The one and only Snoopy hugging Charlie Brown to say "I Love You."', NULL, NULL, '215402p.jpg', 'I Love You Snoopy', 0, 12.99, 't215402p.jpg'),
(49, 'An adorable Winnie the Pooh balloon.', NULL, NULL, '81947pl.jpg', 'Pooh Adult', 0, 12.99, 't81947pl.jpg'),
(50, 'A Pokemon balloon with a lot of mini pictures of the rest of the cast. Pokemon, Gotta catch ''em all!', NULL, NULL, '83947.jpg', 'Pokemon Character', 0, 12.99, 't83947.jpg'),
(51, 'A Pokemon balloon with Ash and Pikachu. Gotta catch ''em all!', NULL, NULL, '83951.jpg', 'Pokemon Ash & Pikachu', 0, 12.99, 't83951.jpg'),
(52, 'The ever-famous Smiley Face balloon on the classic yellow background with three smooch kisses.', NULL, NULL, '16862p.jpg', 'Smiley Kiss Yellow', 0, 12.99, 't16862p.jpg'),
(53, 'A red heart-shaped balloon with a cartoon smiley face.', NULL, NULL, '214154p.jpg', 'Smiley Face', 0, 12.99, 't214154p.jpg'),
(54, 'A soccer-shaped balloon great for any soccer fan.', NULL, NULL, '28734.jpg', 'Soccer Shape', 0, 12.99, 't28734.jpg'),
(55, 'A round soccer balloon. Ideal for any sports fan, or an original way to celebrate an important Goal in that "oh so important" game.', NULL, NULL, 'a1180401.jpg', 'Goal Ball', 0, 12.99, 'ta1180401.jpg'),
(56, 'A white heart-shaped balloon with wedding wishes and intricate designs of doves in silver.', NULL, NULL, '1368601.jpg', 'Wedding Doves', 0, 12.99, 't1368601.jpg'),
(57, 'A transparent heart-shaped balloon with silver roses. Perfect for a silver anniversary or a wedding with a silver theme.', NULL, NULL, '38196.jpg', 'Crystal Rose Silver', 0, 12.99, 't38196.jpg'),
(58, 'A transparent heart-shaped balloon with Gold roses. Perfect for a Golden anniversary or a wedding with a Gold theme.', NULL, NULL, '38199.jpg', 'Crystal Rose Gold', 0, 12.99, 't38199.jpg'),
(59, 'A transparent heart-shaped balloon with red roses. Perfect for an anniversary or a wedding with a red theme.', NULL, NULL, '38202.jpg', 'Crystal Rose Red', 0, 12.99, 't38202.jpg'),
(60, 'A transparent heart-shaped balloon with silver hearts. Perfect for a silver anniversary or a wedding with a silver theme.', NULL, NULL, '42014.jpg', 'Crystal Etched Hearts', 0, 12.99, 't42014.jpg'),
(61, 'A transparent heart-shaped balloon with two love doves in silver.', NULL, NULL, '42080.jpg', 'Crystal Love Doves Silver', 0, 12.99, 't42080.jpg'),
(62, 'A transparent heart-shaped balloon with red hearts.', NULL, NULL, '42139.jpg', 'Crystal Etched Hearts', 0, 12.99, 't42139.jpg'),
(63, 'Adorable balloon that says BAZINGAAAAAAA...', NULL, NULL, 'images.jpg', 'Bazinga', 1, 10, 'images.jpg'),
(64, 'Megamind Megamind Megamind aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa!!!', NULL, NULL, 'tdownload.jpg', 'Megamind', 1, 20, 'tdownload.jpg'),
(65, 'Beautiful balloons from the famous series Breaking Bad', NULL, NULL, 'Breaking_Bad_title_card.png', 'Breaking Bad', 1, 15, 'tBreaking_Bad_title_card.png');

--
-- Dumping data for table `product_category`
--

INSERT INTO `product_category` (`products_id`, `categories_id`) VALUES
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1),
(11, 1),
(12, 1),
(13, 1),
(14, 1),
(15, 1),
(16, 1),
(17, 1),
(18, 1),
(19, 1),
(20, 1),
(26, 1),
(57, 1),
(58, 1),
(60, 1),
(61, 1),
(62, 1),
(4, 2),
(22, 2),
(23, 2),
(24, 2),
(28, 2),
(57, 2),
(58, 2),
(60, 2),
(6, 3),
(56, 3),
(57, 3),
(58, 3),
(60, 3),
(61, 3),
(62, 3),
(4, 4),
(6, 4),
(12, 4),
(13, 4),
(14, 4),
(16, 4),
(17, 4),
(18, 4),
(19, 4),
(20, 4),
(22, 4),
(23, 4),
(26, 4),
(28, 4),
(29, 4),
(30, 4),
(31, 4),
(32, 4),
(33, 4),
(34, 4),
(35, 4),
(36, 4),
(37, 4),
(38, 4),
(25, 5),
(39, 5),
(40, 5),
(41, 5),
(42, 5),
(43, 5),
(44, 5),
(45, 5),
(46, 5),
(47, 5),
(48, 5),
(49, 5),
(50, 5),
(51, 5),
(54, 5),
(55, 5),
(4, 6),
(19, 6),
(28, 6),
(30, 6),
(37, 6),
(38, 6),
(52, 6),
(54, 6),
(55, 6),
(59, 1),
(59, 3),
(3, 1),
(3, 2),
(3, 3),
(3, 4),
(1, 1),
(1, 2),
(1, 8),
(53, 5),
(53, 6),
(53, 8),
(65, 6),
(65, 8),
(65, 9),
(63, 4),
(63, 6),
(63, 8),
(63, 9),
(2, 1),
(2, 4),
(2, 6),
(2, 9),
(64, 5),
(64, 6),
(64, 8),
(64, 9);
NSERT INTO user (id, address, authority, city, country, email, enabled, name, password, surname, zip) VALUES
(1, 'admin', 'ROLE_ADMIN', 'admin', 'admin', 'admin', 1, 'admin', 'admin', 'admin', 1000);
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
