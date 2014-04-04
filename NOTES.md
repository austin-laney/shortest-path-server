Jesse/Bob,

I would like to thank you both for taking the time to speak with me on Monday.
I have completed the requested coding assignment. I made a few iterations in
my approach along the way as you can see from the commit history. I see now why
I was specifically asked some of the questions during our conversation. Many of
the items and techniques I implemented in this project are things I have used
in the passed. However, I categorize my working knowledge of things slightly
different than most. I remember things in a functional way and not by definition.
Either way, I am happy you still gave me the opportunity to display one of my
best skills (the speed at which I can teach myself). 

Listed below are the items I failed to answer correctly on the phone and how I
would answer them after this assignment. Along with how I approached this project
and ultimately decided to accomplish it.

What is the OSI model?

The OSI model is an abstract way of categorizing network communication protocols
and standards in a serve-receive pattern. Meaning each successive category preceding
a given layer services and supports the dependencies that are received and used by
that layer. In order from surface to base:
Application, Presentation, Session, Transport, Network, Data Link, Physical

What is the difference between IPv4 and IPv6?

I was under the assumption at first that this was only created to resolve network
addressing issues. Which is only a small part. IPv6 brings many new optimized items
to network addressing. Like:
-128 bit addressing instead of the 32bit octet of its predecessor.
-Also the removal of NAT

What is the difference between TCP, UDP, & IP?

IP is one that is difficult to forget and I knew what that was, but its been some
time since my last networking class and the last time I had to remember the definitions
of TCP/UDP. Once I started looking it up, I realized I still remembered what they were just
not the acronyms. TCP is a protocol used to order and error-check data transmissions on
a network. UDP is a protocol that can be used control transmission and provide error
checking like TCP. UDP differs in many ways like how it handles connection 'setup'
ports VS handshaking and it how it checks data with checksum VS sequencing.

What would be the time complexity of my pseudo function?

This is tied to BigO. Which I didn't know the definition of. I did know however that
the more steps in a given function/algorithm the more time in cycles it takes to complete
and it grows exponentially with larger and larger data. Nested loops are BIG impactors
of this. I would alleviate issues like this by reducing the number of 'multiplied' cycles,
and reduce as many simple steps as I could in a method,function, or algorithm. I now know
this is Time Complexity and is calculated in BigO notation. 

Finally, What are HashMap, HashTable, and LinkedList and when would you use them?

I categorize these as collections. In my mind they are separated into three areas:
Dictionary, Array, List. Where Dictionary is a collection of Key-Value(s), arrays are
Simple Collections, and List is an object that implements an abstract base class that
extends the functionality of one of the first two. Hash(s) are unique (either key ~ or values for Set)
HashTable is synchronized (good for threading) and does not allow nulls in the key. A HashMap Allows 
a null for the Key and is unsynchronized.(usually faster) A linked list is an ordered list 
where each value has a pointer directed to its predecessor and successor. I was initially
using List<Vertex> for my program, but I wanted to ensure unique vertices and not have to 
iterate to get a specified vertex in my collection. I then chose HashMap<ID, Vertex>

I Started by researching shortest path algorithms and located a lecture on OCW.MIT.EDU
that I then watched and read lecture materials. It described the Dijkstra's process for
next vertex distance comparison. Which I began implementing and continued researching.
I Started another lecture (on Bellman-ford's algorithm) and after thinking of the
possibilities for expanding the program's abilities (negative graphs, non-acyclic graphs,
graph's with negative cycles) I began refactoring and implementing this algorithm. 
Once I finished my research I determined that in this use case: Bellman-Fords approach
would be more costly in cycles (even though the inputs are small). Finally returning the
program to the Dijkstra algorithm. 

Here is what I added to the projected. The input is wrapped in a formatter class. This 
gives me the opportunity to expand for other input formats in the future without having
to refactor. The DiGraph class has an method (though skeletonized) to determine if the
graph is acyclic. If completed this gives me the opportunity to add a method for the
Bellman-Ford algorithm, and choose Dijkstra or Bellman-Ford based upon graph topology.

The result is sent back to the client via the open socket connection in a byte stream.
I hoped to have this to you earlier in the week, but I completed this around my normal
work schedule and my family. 

Again, thank you for talking to me and giving me the opportunity to do this I did enjoy it.

Suggestions for the project
None of the file meta data is sent along with the input. Without this, having the server
update the FileDescriptor seemed a little confusing. Should the server make its own 
copy and save the result to that or write a client application to accompany the server
to receive the result and write it to the opened file.
Everything else was straight forward.

Also, just to let you know NetBeans 7.4 has issues authenticating to github/repositories.
It has been a known bug and has been in and out of the NetBeans bug tracker. I switched 
everything to eclipse after encountering this issue. Git support for NetBeans is still
in beta/unstable. Even though it has been packaged with net beans since 7.2 :)