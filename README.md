# SoftverskiPaterniDomaciStateMachine
Repozitorijum za domaci iz predmeta softverski paterni State machine.

Definition:
State pattern allows object to change its behavior when its internal state is changed.

This example shows the object(Paper - the patterns relational diagram shows it as Context) changing his properties and allowable
transitions to other states. The starting state is WritingState. When object reaches some final state there is no other steps and
application can end.

Implementation:
This program used directional graph to represent state machine and visual representation of transitions based on users choice.
Nodes of graph represent each state. States what out degree is equal to 0 are final states.
Program also uses auxillary arrays of:
  -all states
  -states that current state can transite into
  -each state transition indexes
These arrays are kept in memory so program would not have to use graph search agorithms.

Some of the classes representing the pattern:
StateMachine - model on how states and transitions are stored in memory
State - model of what every concrete state should have
FinalState - inherits State but it is just a representation of state that has no exits(when object reaches this state application ends)
[WritingState, AcceptState, RejectState ...] - concrete states. If another state is required to program it can be added but if a new
  concrete state is added transitions for that state must also be added.
Paper - model of the context whats behavior is depended on states

