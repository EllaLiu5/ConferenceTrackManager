# Conference Track Management
## Prerequisites for Building
* Java 1.8
* Gradle (for building)
* JUnit 
## Prerequisites for Executing the Program
* Java 1.8
## How to Build
cd “path to the root of project”
gradle build
this will generate a jar file under build/libs directory.
## How to Run the Program
After gradle build:
java -jar “path to jar file build after gradle build” “path to input file”
## Design
### Main
* Program entrance. Initiate java util logger, read input file, call ConferenceScheduler to do actual processing and output the result.
### ConferenceScheduler
*	The ConferenceScheduler class provides a method called schedule() as an API to create a Conference object representing a scheduled conference with tracks for the provided input
*	ConferenceScheduler class is the main class to validate talks, create tracks and sessions, schedule talks within each session.
*	Main methods:
  * addValidTalks(): validate each talk and add to talk list.
  *	scheduleTalks(): initiate tracks and sessions and use DP method to schedule talks.
### DPSolver
*	The  DPSolver class provides algorithm to solve best fit problem with a given session duration and a list of talks. 
*	Main methods:
  *	process(): take in sessionTime and list of talks, calculate a list of talks that best fit with the given session duration time. Return a list of Boolean with the same length as list of talks, 0 indicates not picking this talk, 1 indicates corresponding talk is picked.
### Track
*	An object representation of a single track of a conference. Each Track object contains one or more Session
Session
*	Session is an abstract class provides essential time format methods and method signatures that should be implemented by talkSession and intervalSession separately.
talkSession
*	An object representation of a session with talks (morning talk session and afternoon talk session). Each talkSession maintains a local talk list.
*	Main methods:
  *	processTaks(): take in currently unscheduled talks, call DPSolver with session duration time and unscheduled talk list. Add picked talks to this session’s talk list and remove picked talks from unscheduled talk list.
intrvalSession
  *	An object representation of an interval session without talks (lunch session and night event session). 
