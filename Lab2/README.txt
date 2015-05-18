README:

As for the whole project, Basically follow the scenario of design.

Several things to be mentioned:

1. In the portfolio, I just assume that there're only 3 accounts. Just for simple reason. 
2. In the calculation of MacD and ModD, to make the code clean, I encapslated the two calculation methods
   into Calculation class. But I guess making them to class method would be better. we don't have to initialize
   an object everytime. 
3. In the iterator part, I discussed with Kaiyuan about the linkedList iterator.


4. For the new update version, I delete the add and remove method in the super Component class. 
   So the Bond class doesn't have to implement them, Since they can't add or delete. 
   I made the methods only in Portfolio. 
   