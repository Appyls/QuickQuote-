# QuickQuote!
Guides insurance brokers in choosing the right company to go to for the best coverage and price for homeowners policies in BC

Currently Supports: Family Insurance, Gore Mutual Insurance, Intact Insurance, Wawanesa Insurance.

QuickQuote! was developed with the intention to guide Insurance Brokers in their work by greatly simplifying the process of finding the best coverage package for the client.
For the average independant broker, their work flow may look something like this:
1. Get Relevant information from client
2. Calculate the dwelling's replacement cost through a computer program (for example MSB / RCT express)
3. Use another program to generate multiple comparison quotes & premium approximations of different insurance companies
4. Based off of which company has the best coverage & cheapest price, go on the company's portal
5. Use the company's portal to get the actual premium and generate the application

QuickQuote! aims to simplify this process by:
1. Eliminating certain factors that are not needed to generate an accurate quotation
2. Integrating the replacement cost calculation and the comparison quotation into one step
3. Ranking each company from "most suitable" to "least suitable" based on the amount of discounts offerable to the client and if the house is in the company's "target market".
4. Approximating the recommended building limit that would be acceptable by each company's underwriters
5. Serving as a guide to insurance brokers so that they are less likely to make mistakes
6. Allows the broker to immediately know which company is best suited to the client


In a future update I am planning to implement a method to calculate the Sewer Backup Score of a client based off their postal code. I will create a HashMap that correlates the first three letters of the postal code to the company's sewer backup zone, and caluclate if the client's location is in a preferred territory or not.

# UML Diagram:

![ScreenShot](https://user-images.githubusercontent.com/29148427/27764220-d558381e-5e48-11e7-89ea-d76583e8d35f.png)
