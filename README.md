# Java_Projects
This repo showcases some of my Java assignments towards my masters degree
##Assignment 1 - Details
### II.	Assessment Scenario
The Football Club needs an application to select 10 players according to their playing position on the field and to produce various reports. The following players’ details, such as their first and last names, agility and power test (APT) and strength and endurance test (SET) scores, position on the field (defender, midfielder, attacker), and the national association (England, Northern Ireland, Scotland or Wales) to which they currently belong, are entered by the Club Admin/User. The sample data is provided in Table 1. The system should calculate their AVG (average score of APT and SET) and should select players based on Table 1.
##### Table 1: Sample players’ data.
ID	First Name	Last Name	APT	SET	National Association	AVG	Position
1	Daniel	Scott	79	92	Scotland	85.5	Attacker
2	Ali	Aslam	98	94	Northern Ireland	96.0	Midfielder
3	Oliver	Barker	89	95	England	92.0	Defender
  4	Jordan	Robinson	45	89	Wales	67.0	Attacker
5	Steven	Walker	88	87	Wales	87.5	Midfielder
6	Alfie	Loy	85	79	Wales	82.0	Attacker
7	Rashid	Bhatti	90	86	England	88.0	Midfielder
8	Thomas	Taylor	97	85	England	91.0	Defender
9	Theo	Dolan	87	82	Scotland	84.5	Attacker
10	Finley	Cross	95	83	Northern Ireland	89.0	Midfielder
11	Joshua	Mills	92	71	Scotland	81.5	Attacker
12	Leander	Moore	91	72	Northern Ireland	81.5	Midfielder
13	Isaac	Johnson	76	77	England	76.5	Defender
14	William	Adams	78	78	England	78.0	Midfielder
15	Jacob	Stone	77	79	Wales	78.0	Midfielder
16	James	Chaffey	93	70	Wales	81.5	Attacker
17	Lucas	Saunders	68	69	Wales	68.5	Attacker
18	Alexander	Daly	43	67	England	55.0	Midfielder
19	Arlo	Gilchrist	50	65	England	57.5	Attacker

##### III.	Assessment Tasks 
Design and build an application that requires the user to input the player’s fitness score data via the console/command line and store it in an appropriate internal structure. 
●	There is no requirement for this data to be preserved after the application is closed.
●	You will need to consider what the application outputs to the user to demonstrate the results of each task below. 
●	You should provide the user with the means to close the program once operations are complete.
Your application should be able to perform the following tasks as given in Section II. (Scenario):

##### Task A: Write pseudocode algorithms for the tasks given below.

1. The application should take the following input from the user and store it in appropriate data structure: Player’s first name, last name, APT, SET, position (defender, midfielder, attacker) and national association (England, Northern Ireland, Scotland, Wales) as shown in Table 1. 
2. The system should calculate and store average score (AVG) based on APT and SET. Sample data is provided in Table 1.
3. Take user input and according to different playing positions, select a team of ten players from Table 1 by giving preference to those who have a high SET score. The sample user input is given below and sample output is given in Table 2.

  ##### Sample - user input: 
  Enter the required number of defenders = 1
  Enter the required number of midfielders = 2
  Enter the required number of attackers = 7

##### Sample – selected team players based on different positions.
ID	First Name	Last Name	APT	SET	National Association	AVG	Position
3	Oliver	Barker	89	95	England	92.0	Defender
2	Ali	Aslam	98	94	Northern Ireland	96.0	Midfielder
1	Daniel	Scott	79	92	Scotland	85.5	Attacker
  4	Jordan	Robinson	45	89	Wales	67.0	Attacker
5	Steven	Walker	88	87	Wales	87.5	Midfielder
9	Theo	Dolan	87	82	Scotland	84.5	Attacker
6	Alfie	Loy	85	79	Wales	82.0	Attacker
11	Joshua	Mills	92	71	Scotland	81.5	Attacker
16	James	Chaffey	93	70	Wales	81.5	Attacker
17	Lucas	Saunders	68	69	Wales	68.5	Attacker

 ##### 4. Randomly select the number of players based on user input, like that given in Table 3.
 Table 3: Sample report number of players randomly selected.  

  Enter the number of players required: 3

ID	First Name	Last Name	APT	SET	National Association	AVG	Position
2	Ali	Aslam	98	94	Northern Ireland	96.0	Midfielder
11	Joshua	Mills	92	71	Scotland	81.5	Attacker
7	Rashid	Bhatti	90	86	England	88.0	Midfielder

#####  5. Generate a sample report to count the players based on their position, like that given in Table 4.
Table 4: Sample Status Report – Status, Number of players. 
ID	Position	Count
1	Attacker	8
2	Midfielder	8
3	Defender	3
   
##### 6. Sort all players’ data by their APT (from high to low) and generate a report like the sample report given in Table 5.
Table 5. Sample report – players’ data sorted by APT.
ID	First Name	Last Name	APT	SET	National Association	AVG	Position
2	Ali	Aslam	98	94	Northern Ireland	96.0	Midfielder
8	Thomas	Taylor	97	85	England	91.0	Defender
10	Finley	Cross	95	83	Northern Ireland	89.0	Midfielder
16	James	Chaffey	93	70	Wales	81.5	Attacker
11	Joshua	Mills	92	71	Scotland	81.5	Attacker
12	Leander	Moore	91	72	Northern Ireland	81.5	Midfielder
7	Rashid	Bhatti	90	86	England	88.0	Midfielder
3	Oliver	Barker	89	95	England	92.0	Defender
5	Steven	Walker	88	87	Wales	87.5	Midfielder
9	Theo	Dolan	87	82	Scotland	84.5	Attacker
6	Alfie	Loy	85	79	Wales	82.0	Attacker
1	Daniel	Scott	79	92	Scotland	85.5	Attacker
14	William	Adams	78	78	England	78.0	Midfielder
15	Jacob	Stone	77	79	Wales	78.0	Midfielder
13	Isaac	Johnson	76	77	England	76.5	Defender
17	Lucas	Saunders	68	69	Wales	68.5	Attacker
19	Arlo	Gilchrist	50	65	England	57.5	Attacker
4	Jordan	Robinson	45	89	 Wales	67.0	Attacker
18	Alexander	Daly	43	67	England	55.0	Midfielder

#### Find the player with the highest APT score, like that given in Table 6.
Table 6: Sample players’ highest APT fitness score. 
ID	First Name	Last Name	APT	SET	National Association	AVG	Position
1	Ali	Aslam	98	94	Northern Ireland	96.0	Midfielder


 #### Find the player with lowest AVG score, like that given in Table 7.

Table 7: Sample players’ lowest AVG score. 
ID	First Name	Last Name	APT	SET	National Association	AVG	Position
1	Alexander	Daly	43	67	England	55.0	Midfielder
#### Construct the application and implement algorithms.

1.	Develop a single Java program that follows coding conventions and enables the user to: search, sort and select players by using algorithms studied in this module, which you run from the command line.
2.	Implement all the algorithms you have created for Task A.
Note: 
●	You need to ensure that the user input is validated, and feedback is given when an invalid input is entered.
