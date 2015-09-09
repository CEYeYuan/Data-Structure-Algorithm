import random
import sys
import os

print("Hello word")

#comment
'''
multiline comments
'''
#Data type:numbers,strings,lists,tuples,dictionaries(maps)
name="Ye"
print(name)

#operator:+ - * / %(modules/remainder) **(exponential) //(division+round down)
print("5+2=",5+2)
print("5-2=",5-2)
print("5*2=",5*2)
print("5/2=",5/2)
print("5%2=",5%2)
print("5**3=",5**3)
print("5//2=",5//2)
print("5.0//2=",5//2)

'''
5+2= 7
5-2= 3
5*2= 10
5/2= 2.5
5%2= 1
5**3= 125
5//2= 2
print("5//2=",5//2)
'''
#precedence
print("1+2-3*2=",1+2-3*2)
print("(1+2-3)*2=",(1+2-3)*2)
'''1+2-3*2= -3
	(1+2-3)*2= 0
'''

#string in '' or ""
quote="\"Always remember you are unique"
multi_line_quote='''just
like everyone else'''
print(quote+multi_line_quote)
'''
"Always remember you are uniquejust
like everyone else
'''

#format output
print("%s %s %s" %('I like the quotes',quote,multi_line_quote))
'''
I like the quotes "Always remember you are unique just
like everyone else
'''
print('\n'*5)
print("I don't like this ",end="")
print('newlines') #invisible
'''





I don't like this newlines
'''
