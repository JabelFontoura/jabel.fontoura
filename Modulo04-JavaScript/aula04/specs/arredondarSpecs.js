describe('arredondar()', () => {
    it('3.1418.arredondar() deve ser 3.14', () => {
        expect(3.1418.arredondar()).toBe(3.14);
    });
    it('3.1418.arredondar(3) deve ser 3.142', () => {
        expect(3.1418.arredondar(3)).toBe(3.142);
    });
});