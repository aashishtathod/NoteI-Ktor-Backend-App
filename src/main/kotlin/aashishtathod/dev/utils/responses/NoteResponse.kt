package aashishtathod.dev.utils.responses

import aashishtathod.dev.entity.Note
import kotlinx.serialization.Serializable

@Serializable
data class NotesResponse(
    override val status: Int,
    override val message: String,
    val notes: List<Note> = emptyList()

) : BaseResponse {
    companion object {
        fun unauthorized(message: String) = NotesResponse(
            State.UNAUTHORIZED.value,
            message
        )

        fun success(notes: List<Note>) = NotesResponse(
            State.SUCCESS.value,
            "Task successful",
            notes
        )
    }
}

@Serializable
data class NoteResponse(
    override val status: Int,
    override val message: String,
    val noteId: Int? = null
) : BaseResponse {
    companion object {
        fun unauthorized(message: String) = NoteResponse(
            State.UNAUTHORIZED.value,
            message
        )

        fun failed(message: String) = NoteResponse(
            State.FAILED.value,
            message
        )

        fun notFound(message: String) = NoteResponse(
            State.NOT_FOUND.value,
            message
        )

        fun success(id: Int) = NoteResponse(
            State.SUCCESS.value,
            "Task successful",
            id
        )

        fun success() = NoteResponse(
            State.SUCCESS.value,
            "Task successful",
        )
    }
}