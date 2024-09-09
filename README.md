# Binary-Relationship-Test
A program that can read in the set of pairs defining a binary relation over some set of strings and determine some properties of that relation.

For example, this input:

3 <br>
a <br>
b <br>
c <br>
4 <br>
a a <br>
a b <br>
b b <br>
c c <br>
<br>specifies the set {a, b, c} and the relation {(a,a), (a,b), (b,b), (c,c)}. You may assume that the input is well-formed. If it helps, you may assume the input will be split across lines as shown.

Once you have read in the relation, check whether it is reflexive, symmetric, transitive, and antisymmetric, and print out the results. Based on these tests, also print out whether it is an equivalence relation, a partial order, both, or neither.

For example, given the above input, the output should be:

reflexive <br>
not symmetric <br>
transitive <br>
antisymmetric <br>
partial order <br>
