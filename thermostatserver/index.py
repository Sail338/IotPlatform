#ourserver to listen to POST rquest and update a webpage

from flask import Flask
from flask import request
from flask import render_template
app = Flask(__name__)
vals = []
vals.append(70)
#why am I doing a globar var
@app.route('/hi', methods = ['GET','POST'])
def hello_world():
    if (request.method == 'POST'):
         vals.append((request.form['data']))
         return "done"
@app.route('/')
def run():
    lel = vals[len(vals)-1]
    return render_template('index.html',val = lel)

if __name__ == "__main__":
        app.run(debug=True)
