println( (1 to 999).filter(c => c%3 == 0 || c%5 == 0).reduceLeft(_+_) )
