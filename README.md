# Encryptor/Decryptor (hyperskill course)

-----

This program allows you to cipher/decipher the text using Unicode or Shift algorithms.
In order to use it, you should know the arguments, which allows you to configure the program

-----

| Argument | Options         | Description                              |
|----------|-----------------|------------------------------------------|
| -mode    | enc / dec       | Encrypt or Decrypt                       |
| -key     | an digit        | Offset                                   |
| -data    | string value    | The data, that needs to be encrypted     |
| -out     | file path       | File location for the result             |
| -in      | file path       | File location, where the input data lays |
 | -alg     | shift / unicode | Algorithm, that will be used             |

---

#Example of usage

`java Main -mode enc -in road_to_treasure.txt -out protected.txt -key 5 -alg unicode`

Output:

`\jqhtrj%yt%m~ujwxpnqq&`
