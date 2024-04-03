# Write your MySQL query statement below
SELECT
    st.student_id,
    st.student_name,
    sbj.subject_name,
    COUNT(e.student_id) as attended_exams
FROM Students st
    JOIN Subjects sbj
    LEFT JOIN Examinations e ON st.student_id = e.student_id AND sbj.subject_name = e.subject_name
GROUP BY st.student_id, sbj.subject_name
ORDER BY student_id, subject_name