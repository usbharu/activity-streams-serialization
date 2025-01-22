package dev.usbharu.hideout.activitystreams.impl

import dev.usbharu.hideout.activitystreams.Type
import dev.usbharu.hideout.activitystreams.activity.*

interface AbstractActivity : Accept, Add, Announce, Arrive, Block, Create, Delete, Dislike, Flag, Follow, Ignore,
    Invite, Join, Leave, Like, Listen, Move, Offer, Question, Read, Reject, Remove, TentativeAccept, TentativeReject,
    Travel, Undo, Update, View {
    fun isActivity(): Boolean {
        return type.contains(Type.ACCEPT) ||
                type.contains(Type.ADD) ||
                type.contains(Type.ANNOUNCE) ||
                type.contains(Type.ARRIVE) ||
                type.contains(Type.BLOCK) ||
                type.contains(Type.CREATE) ||
                type.contains(Type.DELETE) ||
                type.contains(Type.DISLIKE) ||
                type.contains(Type.DISLIKE) ||
                type.contains(Type.FLAG) ||
                type.contains(Type.FOLLOW) ||
                type.contains(Type.IGNORE) ||
                type.contains(Type.INVITE) ||
                type.contains(Type.JOIN) ||
                type.contains(Type.LEAVE) ||
                type.contains(Type.LIKE) ||
                type.contains(Type.LISTEN) ||
                type.contains(Type.MOVE) ||
                type.contains(Type.OFFER) ||
                type.contains(Type.QUESTION) ||
                type.contains(Type.READ) ||
                type.contains(Type.REJECT) ||
                type.contains(Type.REMOVE) ||
                type.contains(Type.TENTATIVE_ACCEPT) ||
                type.contains(Type.TENTATIVE_REJECT) ||
                type.contains(Type.TRAVEL) ||
                type.contains(Type.UNDO) ||
                type.contains(Type.UPDATE) ||
                type.contains(Type.VIEW)
    }
}