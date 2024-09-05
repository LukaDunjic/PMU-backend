
-- Ponovno kreiranje stranog ključa sa ON DELETE CASCADE
ALTER TABLE section_ownership
ADD CONSTRAINT fk_section_id
FOREIGN KEY (section_id)
REFERENCES section(section_id)
ON DELETE CASCADE;
