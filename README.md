# A2A deep dive - Quarkus Examples

Code shown in Devoxx Belginm 2025 deep dive:
On standards and AI agents: a walkthrough of MCP, A2A, ADK and more

Specificlaly the A2A demos

## Story

The demo is an agentic based Todo application
that tries to help users by using AI to do the Todos automatically.

It uses A2A agents to add capabilities and the Todo app selects the most appropriate agent for the task.

## Parts

The demos have the following parts

* A Quarkus based Weather agent implement A2A Server
* A JS GenKit based Movie Agent implementing A2A Server (outside this repo)
* A Quarkus based agentic Todo application implementing A2A Client
* A2A Inspector (outside this repo)

##W The Quarkus Weather Agent

It's a A2A server.

Located in [0-weather-agent](./0-weather-agent)

You need to set as environment variable `OPEN_AI_KEY`.
For example in a `.env` file.

### The Movie agent app

It's an app from the A2A samples portfolio, 
you can find it at `https://github.com/a2aproject/a2a-samples/tree/main/samples/js/src/agents/movie-agent`

`git clone https://github.com/a2aproject/a2a-samples/tree/main/samples/js/src/agents/movie-agent`
And follow their instructions, in particular set as environment variables `GEMINI_API_KEY` and `TMDB_API_KEY`.

### A2A Inspector

It's a nice tool to see how A2A Servers are operating and to debug them.
You can find it at https://github.com/a2aproject/a2a-inspector

Follow the instructions to install them

### The Agentic Todo app

Located in [2-agentic-todo-app](./2-agentic-todo-app).
You need the following environment variables:
* `OPENAI_API_KEY`
* `JAVA_HOME` (Java 21)

Run `mvn quarkus:dev` or `quarkus dev` if you have the Quarkus CLI installed.

Click on one todo to get the detailed screen, cliock on Do with AI to see whether the task can be done automatically.

Try and enter the following ones to see what is going on

* `Find what the weather is in Houston`
* `Who is playing Sam in that Australian movie`
  * (when required for details), `The movie is Penguin Bloom`

### Content Writer

The Content writer is not used in the demo but it is a Quarkus based A2A server using OpenAI.
It can be used in the [A2A Sample multi agent demo](https://github.com/a2aproject/a2a-samples/tree/main/samples/python/hosts/content_creation).

## License

The code is licensed under the ASL 2.0, see [LICENSE](./LICENSE).