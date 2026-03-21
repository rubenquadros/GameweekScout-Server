# GameweekScout-Server

GameweekScout is an AI agent which helps you with suggestions for your [FPL][fpl] team.

It uses [Koog][koog] under the hood to talk to LLMs and provide the output. Currently, it supports only Gemini Models.

It uses FPL APIs to provide data to the LLMs.

This is the backend server to a simple web interface(WIP) which lets you chat with the agent.

It uses [Ktor][ktor] to set up the server. 

## Local setup

To enable local runs please follow these instructions:

- Create `local.properties` at the root of the project and add the following params:
```text
geminiApiKey=Your gemini API key
suggestionModel=Model to use for suggestions (Recommended Flash)
inputProcessModel=Model to use for reading query sentiment (Recommended Lite)
retrievalModel=Model to use for context compression (Recommended Lite)
defaultModel=Default fallback model (Recommended Flash)
adminAccountPath=Location of admin_access.json file needed to access Firestore database (Recommended root of the project)
dbUrl=The database url of your Firestore database (https://<DATABASE_NAME>.firebaseio.com/
```

### Get Gemini API key via Google AI studio

Follow the instructions [here][gemini_key] and set up your account to get your Gemini API key 

### Firebase project

Set up your [Firebase][firebase] project and enable Firestore database. This is required to enable persistence in Koog.

The project uses Firebase Admin SDK to talk to the Firestore database. Please follow the instructions [here][admin_sdk] to generate your admin JSON file.
Specifically follow the steps for `Initializing the SDK in non-Google environments`.

### Running the server
- You can run the project in your favourite IDE to get the server up
- Make sure to add the **USER_ID** header with a dummy value (Required to be passed by the web interface)
- Once the server is up, you can make a post request to `http://localhost:8080/scout-advice` with the following request body:

```json
{
    "query": "Provide your FPL query!"
}
```

[fpl]:https://fantasy.premierleague.com/
[koog]:https://docs.koog.ai/
[ktor]:https://ktor.io/docs/server-create-a-new-project.html
[gemini_key]:https://ai.google.dev/gemini-api/docs/api-key
[firebase]:https://firebase.google.com/
[admin_sdk]:https://firebase.google.com/docs/admin/setup