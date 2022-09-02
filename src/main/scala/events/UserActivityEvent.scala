package events

import java.time.LocalDateTime

class UserActivityEvent (
                          private final val courseId: String,
                          private final val userId: String,
                          private final val sessionId: String,
                          private final val activityEvent: String,
                          private final val time: LocalDateTime
                        )
  extends Event {

  def getCourseId: String = this.courseId
  def getUserId: String = this.userId
  def getSessionId: String = this.sessionId
  def getActivityEvent: String = this.activityEvent
  def getTime: LocalDateTime = this.time

}
