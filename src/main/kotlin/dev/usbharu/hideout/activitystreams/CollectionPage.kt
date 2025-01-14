package dev.usbharu.hideout.activitystreams

interface CollectionPage : Collection {

    var partOf: CollectionOrLink?
        get() = jsonObject.obtain(Properties.PART_OF)?.asArray()?.firstOrNull()
            ?.let { DefaultObjectFactory.create(it) } as? CollectionOrLink
        set(value) = jsonObject.setOrRemove(Properties.PART_OF, value?.json)

    var next: CollectionPageOrLink?
        get() {
            val jsonArray = jsonObject.obtain(Properties.NEXT)?.asArray() ?: return null
            return jsonArray.firstOrNull()?.let { DefaultObjectFactory.create(it) as CollectionPageOrLink }
        }
        set(value) = jsonObject.setOrRemove(Properties.NEXT, value?.json)

    var prev: CollectionPageOrLink?
        get() {
            val jsonArray = jsonObject.obtain(Properties.PREV)?.asArray() ?: return null
            return jsonArray.firstOrNull()?.let { DefaultObjectFactory.create(it) as CollectionPageOrLink }
        }
        set(value) = jsonObject.setOrRemove(Properties.PREV, value?.json)
}