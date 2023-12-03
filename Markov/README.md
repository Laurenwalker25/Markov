## Introduction

Random Markov processes are widely used in Computer Science and in analyzing different forms of data. This project offers a look at a *generative model* for creating realistic-looking text in a data-driven way. To do so, I implement two classes: First `WordGram` which represents immutable sequences of words, then `HashMarkov` which will be an efficient model for generating random text that uses `WordGram`s and `HashMap`s.

To begin, I select a random k-gram from the *training text* (the data I use to create our model; I want to generate random text similar to the training text). Then, I look for instances of that k-gram in the training text in order to calculate the probabilities corresponding to words that might follow. I then generate a new word according to these probabilities, after which I repeat the process using the last k-1 words from the previous k-gram and the newly generated word. I continue in that fashion to create the desired number of random words. 
