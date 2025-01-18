package dev.usbharu.hideout.activitystreams.impl

import dev.usbharu.hideout.activitystreams.activity.*

interface AbstractActivity : Accept, Add, Announce, Arrive, Block, Create, Delete, Dislike, Flag, Follow, Ignore,
    Invite, Join, Leave, Like, Listen, Move, Offer, Question, Read, Reject, Remove, TentativeAccept, TentativeReject,
    Travel, Undo, Update, View {}