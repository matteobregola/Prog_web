This implementation is built on the CalculatorwithCookies one.

**It has some differences:**

1. *Calculator*:
    1. Search if the name is present in the session, not from the cookie.
    2. It has a method to deal with invalid sessions
<br></br>
2. *index*:
   1. Search if the name is present in the session, not from the cookie.
   2. It uses the encoded_url method, in case that cookies are disabled.
<br></br>
3. *input*:
    1. Search if the name is present in the session, not from the cookie.
    2. If the user is new I have to create a session, adding the name and first iteration attribute.
<br></br>
4. *output*:
   1. Search if the name is present in the session, not from the cookie.
   2. Sends control to error.html if the session is invalid.
<br></br>
5. *endSession*:
   1. Asks if the session (and not the cookie) needs to be closed. (Then end handles what to do).
<br></br>
6. *end*:
   1. Search if the name is present in the session, not from the cookie.
   2. Invalidate the session if the value is true, otherwise, sets first interaction true.
<br></br>
<br></br>
In the web.html the session is set to last 30 minutes.


